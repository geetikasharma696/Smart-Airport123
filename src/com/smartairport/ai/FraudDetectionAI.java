
package com.smartairport.ai;


import com.smartairport.model.Passenger;



public class FraudDetectionAI {



    public String analyzePassenger(Passenger passenger){



        int riskScore = 0;


        String reason = "";



        if(passenger.getBaggageWeight() > 25){

            riskScore += 40;

            reason += "Heavy baggage detected. ";

        }




        if(passenger.getAge() < 18){

            riskScore += 20;

            reason += "Age verification required. ";

        }





        if(riskScore >= 60){


            return
                    "AI SECURITY ANALYSIS\n\n"
                            +"Passenger : "
                            + passenger.getName()
                            +"\n\nRisk Score : "
                            +riskScore
                            +"%\nRisk Level : HIGH\n\nReason : "
                            +reason;


        }



        else if(riskScore >= 30){


            return
                    "AI SECURITY ANALYSIS\n\n"
                            +"Passenger : "
                            + passenger.getName()
                            +"\n\nRisk Score : "
                            +riskScore
                            +"%\nRisk Level : MEDIUM\n\nReason : "
                            +reason;



        }


        else{


            return
                    "AI SECURITY ANALYSIS\n\n"
                            +"Passenger : "
                            + passenger.getName()
                            +"\n\nRisk Score : "
                            +riskScore
                            +"%\nRisk Level : LOW\n\nPassenger Safe";


        }



    }


}