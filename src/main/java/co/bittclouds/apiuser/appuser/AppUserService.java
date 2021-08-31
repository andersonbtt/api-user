package co.bittclouds.apiuser.appuser;

import co.bittclouds.apiuser.registration.token.ConfirmationToken;
import co.bittclouds.apiuser.registration.token.ConfirmationTokenService;
import co.bittclouds.apiuser.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email %s not found.";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public String signUpUser (AppUser appUser){
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already taken!");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        //TODO: Send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //TODO: Send email

        return confirmationToken.getToken();
    }

    public void enableAppUser(String email) {
        Optional<AppUser> appUser = appUserRepository.findByEmail(email);
        if(!appUser.isPresent()){
            throw new IllegalStateException("User Not Found");
        }
        AppUser foundAppUser = appUser.get();
        foundAppUser.setEnabled(true);
        appUserRepository.save(foundAppUser);
    }
}
