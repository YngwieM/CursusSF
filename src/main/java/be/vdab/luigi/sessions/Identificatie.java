package be.vdab.luigi.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Component
@SessionScope
public class Identificatie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Email
    private String emailAdres;

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public String getEmailAdres() {
        return emailAdres;
    }
}