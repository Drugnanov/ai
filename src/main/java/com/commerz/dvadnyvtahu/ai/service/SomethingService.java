package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.client.midjourney.Message;
import com.commerz.dvadnyvtahu.ai.client.midjourney.MidJourneyClient;
import com.commerz.dvadnyvtahu.ai.domain.Test;
import com.commerz.dvadnyvtahu.ai.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SomethingService {

    @Autowired
    private TestRepository testRep;

    @Autowired
    private MidJourneyClient mj;

//    @Autowired
//    private FileIo fi;

    @Autowired
    ResourceLoader resourceLoader;

    @Value("${app.mj.token}")
    private String token;

    private String getToken() {
        return "Bearer " + token;
    }

    static List<Test> tests = new ArrayList<Test>();
    static long id = 0;

    public List<Test> findAll() {
        return testRep.findAll();
    }

    public Test save(Test test) {
        return testRep.save(test);
    }


    public Message testMj() {
        ImageRequest ir = new ImageRequest();
        ir.setMsg("https://uloz.to/quickDownload/KkpbZu96Flmx view the man in the picture as a surfer");
        Message m =  mj.executePrompt(getToken(), ir);
        return m;
    }


    //Does not work
//    public ImageUpload uploadFile() {
//        Resource resource = resourceLoader.getResource("classpath:images/drug.png");
//        try {
//            StringBuilder binary = new StringBuilder();
//            DataInputStream input = new DataInputStream(resource.getInputStream());
//            try {
//                while (true) {
//                    binary.append(Integer.toBinaryString(input.readByte()));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            byte[] fileContent = resource.getContentAsByteArray();
//            String encodedString = Base64.getEncoder().encodeToString(fileContent);
//
//            ImageUpload iu = new ImageUpload();
//            iu.setFile(encodedString);
//            iu.setFile(binary.toString());
//            ImageUploadResponse iur = fi.uploadImage(iu);
//
//            return mj.getAddressByEmployeeId("Bearer " + token, ir);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}