package com.xuningxin;

import com.xuningxin.ref.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpStrategyApplication {

    static void run(){
        Zoo zoo = new Zoo();
        zoo.openDuckArea();
    }


	public static void main(String[] args) {
		SpringApplication.run(DpStrategyApplication.class, args);
		run();
	}

}

