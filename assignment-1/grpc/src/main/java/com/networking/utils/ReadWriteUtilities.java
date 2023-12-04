package com.networking.utils;

import com.networking.grpc.Schema;

public class ReadWriteUtilities {

    public static Schema.Request orderRequestBuilder () {
        Schema.Request.Builder  builder = Schema.Request.newBuilder();
        Schema.Order.Builder orderbuilder = Schema.Order.newBuilder();


        Schema.Vegetable.Builder vegetable = Schema.Vegetable.newBuilder();
        vegetable.setTomato(1.5f);
        vegetable.setLettuce(2.5f);
        vegetable.setCucumber(3.5f);
        orderbuilder.setVeggies(vegetable);


        Schema.Drink.Builder drinks = Schema.Drink.newBuilder();
        drinks.setCoke(12);
        drinks.setBeer(13);
        orderbuilder.setDrinks(drinks);


        Schema.Bottle.Builder bottles = Schema.Bottle.newBuilder();
        bottles.setPepsi(12);
        bottles.setSprite(23);
        orderbuilder.setBottles(bottles);


        Schema.Milk.Builder milk = Schema.Milk.newBuilder();
        milk.setQuantity(2);
        milk.setType(Schema.MilkType.FatFree);
        orderbuilder.setMilk(milk);


        Schema.Bread.Builder bread = Schema.Bread.newBuilder();
        bread.setQuantity(3);
        bread.setType(Schema.BreadType.White);
        orderbuilder.setBread(bread);


        return builder.setOrder(orderbuilder).build();

    }
    public static void readOrderRequest (Schema.Order order){
        Schema.Vegetable veggies = order.getVeggies();
        System.out.println("---- Vegetable details ----> " + veggies.getCucumber() + ":"+veggies.getTomato()+ ":"+veggies.getLettuce());
        Schema.Drink drinks = order.getDrinks();
        System.out.println("---- Drink details ----> " + drinks.getBeer() + ":"+drinks.getCoke());
        Schema.Bottle bottles = order.getBottles();
        System.out.println("---- Bottle details ----> " + bottles.getPepsi() + ":"+bottles.getSprite());
        Schema.Milk milk = order.getMilk();
        System.out.println("---- Milk details ----> " + milk.getQuantity() + ":"+milk.getType());
        Schema.Bread breads = order.getBread();
        System.out.println("---- Bread details ----> " + breads.getQuantity() + ":"+breads.getType());

    }

    public static Schema.Request healthRequestBuilder () {
        Schema.Request.Builder  builder = Schema.Request.newBuilder();
        Schema.Health.Builder healthRequest = Schema.Health.newBuilder();
        healthRequest.setDispenser(Schema.DispenserStatus.OPTIMAL);
        healthRequest.setIcemaker(2);
        healthRequest.setLightbulb(Schema.LightbulbStatus.LIGHTBULB_GOOD);
        healthRequest.setFreezerTemp(32);
        healthRequest.setFridgeTemp(23);
        healthRequest.setSensorStatus(Schema.SensorStatus.SENSOR_BAD);
        healthRequest.setMicrowaveStatus(Schema.MicrowaveStatus.MICROWAVE_GOOD);
       // healthRequest.setDishwasherStatus(Schema.DishwasherStatus.UNRECOGNIZED);
        return builder.setHealth(healthRequest).build();

    }

    public static void readHealthRequest (Schema.Health health){

        System.out.println("---- Dispenser details ----> " + health.getDispenser().toString());
        System.out.println("---- IceMaker details ----> " + health.getIcemaker());
        System.out.println("---- LightBulb details ----> " + health.getLightbulb().toString());
        System.out.println("---- Freezer Temp  details ----> " + health.getFreezerTemp());
        System.out.println("---- Fridger Temp  details ----> " + health.getFridgeTemp());
        System.out.println("---- Sensor details ----> " + health.getSensorStatus().toString());
        System.out.println("---- Microwave details ----> " + health.getMicrowaveStatus().toString());
        System.out.println("---- Dishwasher details ----> " + health.getDishwasherStatus().toString());


    }
    public static Schema.Response resposneBuilder () {
        Schema.Response.Builder responseBuilder = Schema.Response.newBuilder();
        responseBuilder.setCode(Schema.ResponseCode.OK);
        responseBuilder.setContents("Response is successful");
        return responseBuilder.build();


    }

    public static void readResposne (Schema.Response response ){

        System.out.println("---- Response Code ----> " + response.getCode());
        System.out.println("---- Response Status ----> " + response.getContents().toString());


    }

    public static void main(String[] args) {
        System.out.print("Investigating health issue");
        Schema.Request request = ReadWriteUtilities.healthRequestBuilder();
    }

}
