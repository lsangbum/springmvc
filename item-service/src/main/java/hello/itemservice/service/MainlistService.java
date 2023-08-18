package hello.itemservice.service;

import hello.itemservice.mapper.MainlistMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainlistService {

    private final MainlistMapper mainlistMapper;

    public void insertTest(String values){
        String uuid = UUID.randomUUID().toString();
        log.info("##########uuid : " + uuid);
        log.info("##########values : " + values);
        mainlistMapper.insertTest(uuid, values);
    }

    public void loginTest(String userName, String passwordName) {

        mainlistMapper.loginTest(userName, passwordName);
    }
}
