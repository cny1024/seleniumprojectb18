package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void faker_test(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name = " + name);

        String firstName = faker.name().firstName(); // Emory
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName(); // Barton
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAddress = " + streetAddress);

        System.out.println("-=-=-=-=-=-=-=-=-=-");

        String gameOfThrone = faker.gameOfThrones().quote();
        System.out.println("gameOfThrone = " + gameOfThrone);

        String lol = faker.leagueOfLegends().champion();
        System.out.println("lol = " + lol);

        String lotr = faker.lordOfTheRings().character();
        System.out.println("lotr = " + lotr);

        String himym = faker.howIMetYourMother().character();
        System.out.println("himym = " + himym);

        String xxx = faker.gameOfThrones().character();
        System.out.println("xxx = " + xxx);

    }

}
