package co.bittclouds.apiuser.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }

    public void setConfirmedAt(String token) {
        Optional<ConfirmationToken> confirmationToken = confirmationTokenRepository.findByToken(token);
        if(!confirmationToken.isPresent()){
            throw new IllegalStateException("Token Not Found");
        }
        ConfirmationToken foundConfirmationToken = confirmationToken.get();
        foundConfirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(foundConfirmationToken);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }
}
