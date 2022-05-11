package pl.sterniczuk.conference.mail;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Service
public class Mail {

    public void send(String email, String login) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(login + ".txt");
        printWriter.write("użytkownik: " + login + ", i adresie email " +
                 email + " zapisał się na jakieś szkolenie");
        printWriter.close();
    }
}
