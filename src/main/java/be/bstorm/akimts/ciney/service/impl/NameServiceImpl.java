package be.bstorm.akimts.ciney.service.impl;

import be.bstorm.akimts.ciney.service.NameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NameServiceImpl implements NameService {

    @Override
    public List<String> generateNames(int quantity, int length) {
        Random rdm = new Random();
        List<String> names = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append( (char)rdm.nextInt('a', 'z') );
            }
            names.add( sb.toString() );

        }

        return names;
    }

}
