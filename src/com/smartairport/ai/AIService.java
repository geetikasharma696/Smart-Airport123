package com.smartairport.ai;

import com.smartairport.model.Passenger;


public class AIService {


    public String analyzePassenger(Passenger passenger) {


        int riskScore = 0;


        if(passenger.getBaggageWeight() > 25) {

            riskScore += 40;

        }



        String riskLevel;


        if(riskScore >= 40) {

            riskLevel = "MEDIUM";

        }

        else {

            riskLevel = "LOW";

        }



        return
                "===== AI SECURITY ANALYSIS =====\n\n" +

                        "Passenger : "
                        + passenger.getName()
                        + "\n\nRisk Score : "
                        + riskScore
                        + "\nRisk Level : "
                        + riskLevel;

    }

}