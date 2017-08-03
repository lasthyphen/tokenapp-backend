package io.modum.tokenapp.minting;

import io.modum.tokenapp.minting.service.Minting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={
        "io.modum.tokenapp.minting",
        "io.modum.tokenapp.rates",
        "io.modum.tokenapp.backend"})
@SpringBootApplication
public class MintingApplication implements CommandLineRunner {

    @Autowired
    private Minting minting;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MintingApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        //app.setWebEnvironment(false);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("go minting, go!!");
        if(args.length > 0) {
            minting.mint();
        }
    }
}