package mk.ukim.lab.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String firstName, String lastName, String bio) {
        this.id = ThreadLocalRandom.current().nextLong(1, 1001);
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

}
