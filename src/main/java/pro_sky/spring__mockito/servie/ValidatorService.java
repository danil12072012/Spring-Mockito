package pro_sky.spring__mockito.servie;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro_sky.spring__mockito.exception.IncorrectNameException;
import pro_sky.spring__mockito.exception.IncorrectSurnameException;
@Service
public class ValidatorService {
    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!StringUtils.isAlpha(surnames[i])) {
                throw new IncorrectSurnameException();
            }
            surnames[i] = StringUtils.capitalize(surnames[i].toLowerCase());
        }
        return String.join("-", surnames);
    }
}
