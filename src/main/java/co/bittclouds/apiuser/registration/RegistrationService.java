package co.bittclouds.apiuser.registration;

import co.bittclouds.apiuser.appuser.AppUser;
import co.bittclouds.apiuser.appuser.AppUserRole;
import co.bittclouds.apiuser.appuser.AppUserService;
import co.bittclouds.apiuser.registration.token.ConfirmationToken;
import co.bittclouds.apiuser.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        return appUserService.signUpUser(
          new AppUser(
                  request.getFirstName(),
                  request.getLastName(),
                  request.getEmail(),
                  request.getPassword(),
                  AppUserRole.USER
          )
        );
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(()->
                    new IllegalStateException("Token Not Found"));
        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("Email Already Confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token Expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }

}
