package ru.dme.t;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.request.ObjectFactory;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Checker {
    long inn;
    ObjectFactory objectFactory = new ObjectFactory();
    NdsRequest2 request = objectFactory.createNdsRequest2();
    NdsRequest2.NP ndsRequest2NP = objectFactory.createNdsRequest2NP();
    FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2();

    public Checker(long inn) {
        this.inn = inn;
    }

    public Checker() {
        this.inn = readInn();
    }

    private long readInn() {
        long inn = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Пожалуйста, введите ИНН: ");
        try {
             inn = Long.parseLong(br.readLine());
            long innMax=9999999999L;
            if(inn == 0 || inn < 0 || inn > innMax || inn <= 999999999L) {
                System.out.println("Некорректное значение ИНН.");
                readInn();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inn;
    }

    public void checkInn() {
        ndsRequest2NP.setINN(String.valueOf(inn));
        request.getNP().add(ndsRequest2NP);
        NdsResponse2 ndsResponse2 = fnsndscaws2.getFNSNDSCAWS2Port().ndsRequest2(request);
        for (NdsResponse2.NP np : ndsResponse2.getNP()) {
            System.out.println(StateDecoder.getStateDesc(np.getState()));
        }
    }
}
