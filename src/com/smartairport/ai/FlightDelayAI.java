package com.smartairport.ai;
import com.smartairport.model.Flight;

public class FlightDelayAI {

    public String predictDelay(Flight flight){



        int delayScore = 0;

        String reason = "";




        if(flight.getDestination()
                .equalsIgnoreCase("London")
                ||
                flight.getDestination()
                        .equalsIgnoreCase("New York")){


            delayScore += 40;

            reason += "Long international route. ";

        }




        if(flight.getDepartureTime()
                .contains("PM")){


            delayScore += 20;

            reason += "Peak hour traffic. ";

        }




        if(delayScore >= 60){


            return

                    "AI FLIGHT DELAY PREDICTION\n\n"
                            +"Flight : "
                            +flight.getFlightNumber()
                            +"\n\nDelay Probability : "
                            +delayScore
                            +"%\nPrediction : DELAY POSSIBLE\n\nReason : "
                            +reason;


        }




        else if(delayScore >=30){



            return

                    "AI FLIGHT DELAY PREDICTION\n\n"
                            +"Flight : "
                            +flight.getFlightNumber()
                            +"\n\nDelay Probability : "
                            +delayScore
                            +"%\nPrediction : MODERATE RISK\n\nReason : "
                            +reason;


        }





        else{


            return

                    "AI FLIGHT DELAY PREDICTION\n\n"
                            +"Flight : "
                            +flight.getFlightNumber()
                            +"\n\nDelay Probability : "
                            +delayScore
                            +"%\nPrediction : ON TIME\n\nFlight Status Normal";


        }



    }


}