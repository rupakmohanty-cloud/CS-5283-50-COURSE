package com.networking.utils;

import com.google.flatbuffers.FlatBufferBuilder;
import com.networking.flatbuffers.zmq.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderSerializer {


    public static Order deserializeOrder(byte[] data) {
        // Create a ByteBuffer from the byte array
        ByteBuffer bb = ByteBuffer.wrap(data);
        // Get the root object from the buffer
        return Order.getRootAsOrder(bb);
    }



    public static Response deserializeResponse(byte[] data) {
        // Create a ByteBuffer from the byte array
        ByteBuffer bb = ByteBuffer.wrap(data);
        // Get the root object from the buffer
        return Response.getRootAsResponse(bb);
    }


    public static byte[] serializeResponse(Response resposne){
        FlatBufferBuilder builder = new FlatBufferBuilder(0);

        Response.startResponse(builder);
        Response.addCode(builder,ResponseCode.OK);
       /* int name = builder.createString("Response send successfully");
        Response.addContents(builder,name);*/
        // Finish building the Order object and get its offset
        int responseoffset = Response.endResponse(builder);
        // Finish the buffer and return the byte array
        builder.finish(responseoffset);
        return builder.sizedByteArray();


    }

    public static byte[] serializeHealth(Health health){
        FlatBufferBuilder builder = new FlatBufferBuilder(0);
        /* Create Vegetables */
        Health.startHealth(builder);
        Health.addDispenser(builder,DispenserStatus.OPTIMAL);
        Health.addIcemaker(builder,1);
        Health.addLightbulb(builder,LightbulbStatus.GOOD);
        Health.addFridgeTemp(builder,1);
        Health.addFreezerTemp(builder,1);
        Health.addSensorStatus(builder,SensorStatus.GOOD);

        // Finish building the Order object and get its offset
        int healthOffset = Health.endHealth(builder);
        // Finish the buffer and return the byte array
        builder.finish(healthOffset);
        return builder.sizedByteArray();


    }


    public static Order deserializeOrderData(byte[] data ){
        ByteBuffer bb = ByteBuffer.wrap(data);
        // Get the root object from the buffer
        Order orderData =  Order.getRootAsOrder(bb);
        return orderData;
    }

   /* public static void displayOrderData(byte[] data ){
        ByteBuffer bb = ByteBuffer.wrap(data);
        // Get the root object from the buffer
        Order orderData =  Order.getRootAsOrder(bb);
        Vegetable veggies = orderData.veggies(0);
        System.out.println(veggies.tomato() + " " + veggies.cucumber() + " " + veggies.lettuce());
        System.out.println(orderData.drinks(0).coke() + " " + orderData.drinks(0).beer() + " " + orderData.drinks(0).juice());
        System.out.println(orderData.bottles(0).sprite()+ " " + orderData.bottles(0).pepsi() + " " + orderData.bottles(0).whitewine());
        System.out.println(orderData.milk(0).type()+ " " + orderData.milk(0).quantity());
        System.out.println(orderData.bread(0).type()+ " " + orderData.bread(0).quantity());
        System.out.println(orderData.meat(0).type()+ " " + orderData.meat(0).quantity());

    }*/

   /* public static byte[] serializeOrderData(Order order){
        FlatBufferBuilder builder = new FlatBufferBuilder(0);
        int onionOffset = builder.createString("tomato");
        int carrotOffset = builder.createString("cucumber");
        int napaOffset = builder.createString("lettuce");
        Vegetable.startVegetable(builder);
        Vegetable.addTomato(builder, 1.0f);
        Vegetable.addCucumber(builder, 2.0f);
        Vegetable.addLettuce(builder, 3.0f);
        int veggiesOffset = Vegetable.endVegetable(builder);


        Drink.startDrink(builder);
        Drink.addCoke(builder, 1);
        Drink.addBeer(builder, 2);
        Drink.addJuice(builder,3);
        int drinksOffset = Drink.endDrink(builder);


        Bottle.startBottle(builder);
        Bottle.addSprite(builder, 1);
        Bottle.addPepsi(builder, 2);
        Bottle.addWhitewine(builder, 3);
        int bottlesOffset = Bottle.endBottle(builder);


        Milk.startMilk(builder);
        Milk.addType(builder, MilkType.Whole);
        Milk.addQuantity(builder, 8.0f);
        int milkOffset = Milk.endMilk(builder);


        Bread.startBread(builder);
        Bread.addType(builder, BreadType.White);
        Bread.addQuantity(builder, 9.0f);
        int breadOffset = Bread.endBread(builder);

        Meat.startMeat(builder);
        Meat.addType(builder, MeatType.Beef);
        Meat.addQuantity(builder, 10.0f);
        int meatOffset = Meat.endMeat(builder);

        Order.startOrder(builder);
        Order.addVeggies(builder, veggiesOffset);
        Order.addDrinks(builder, drinksOffset);
        Order.addBottles(builder, bottlesOffset);
        Order.addMilk(builder, milkOffset);
        Order.addBread(builder, breadOffset);
        Order.addMeat(builder, meatOffset);
        int orderOffset = Order.endOrder(builder);
        builder.finish(orderOffset);
        builder.finish(orderOffset);
        ByteBuffer buffer = builder.dataBuffer();
        return buffer.array();
    }*/

    public static void displayOrder(byte[] data){
        Order order_data = new Order();
        Order response  =  OrderSerializer.deserializeOrder(data);
        System.out.println(" value " +response.toString());
        for (int i = 0; i < response.veggiesLength();i++) {
            System.out.println("Vegetable Details");
            System.out.println(response.veggies(i).lettuce() + " " + response.veggies(i).cucumber() + " " + response.veggies(i).cucumber());

        }
        for (int i = 0; i < response.drinksLength();i++) {
            System.out.println("Drinks Details");
            System.out.println(response.drinks(i).beer()+ " " + response.drinks(i).coke() + " " + response.drinks(i).juice());

        }

        for (int i = 0; i < response.bottlesLength();i++) {
            System.out.println("Bottles Details");
            System.out.println(response.bottles(i).sprite()+ " " + response.bottles(i).pepsi() + " " + response.bottles(i).whitewine());

        }

        for (int i = 0; i < response.milkLength();i++) {
            System.out.println("Milk Details");
            System.out.println(response.milk(i).type()+ " " + response.milk(i).quantity());

        }

        for (int i = 0; i < response.breadLength();i++) {
            System.out.println("Bread Details");
            System.out.println(response.bread(i).type()+ " " + response.bread(i).quantity());

        }

        for (int i = 0; i < response.meatLength();i++) {
            System.out.println("Meat Details");
            System.out.println(response.meat(i).type()+ " " + response.meat(i).quantity());

        }

    }
    public static byte[] serializeOrder(Order order){
        FlatBufferBuilder builder = new FlatBufferBuilder(0);
        /* Create Vegetables */
        float tomato1 = 1.0f;
        float cucumber1 = 2.0f;
        float lettuce1 = 3.0f;
        float tomato2 = 1.0f;
        float cucumber2 = 2.0f;
        float lettuce2= 3.0f;

        int[] vegetables  = new int[2];
        vegetables [0] = Vegetable.createVegetable(builder,1.0f,2.0f,3.0f);
        vegetables [1] = Vegetable.createVegetable(builder,2.0f,3.0f,4.0f);


        /*create Drink*/
        int[] drink  = new int[2];
        drink [0] = Drink.createDrink(builder,1,2,3);
        drink [1] = Drink.createDrink(builder,2,4,5);

        /*create Bottle*/

        int[] bottle  = new int[2];
        bottle [0] = Bottle.createBottle(builder,1,2,3);
        bottle [1] = Bottle.createBottle(builder,3,4,5);

        /* Create milk */
        int[] milk  = new int[2];
        milk [0] = Milk.createMilk(builder,MilkType.FatFree,8.0f);
        milk [1] = Milk.createMilk(builder,MilkType.Whole,5.0f);

        /* Create bread */
        int[] bread  = new int[2];
        bread [0] = Bread.createBread(builder,BreadType.MultiGrain,1.0f);
        bread [1] = Bread.createBread(builder,BreadType.White,1.0f);

        /* Create Meat */
        int[] meat  = new int[2];
        meat [0] = Meat.createMeat(builder,MeatType.Chicken,1.0f);
        meat [1] = Bread.createBread(builder,MeatType.Pork,1.0f);

        int veggiesVector = Order.createVeggiesVector(builder, vegetables);
        int drinksVector = Order.createDrinksVector(builder, drink);
        int bottlesVector = Order.createBottlesVector(builder, bottle);
        int milkVector = Order.createMilkVector(builder, milk);
        int breadVector = Order.createBreadVector(builder, bread);
        int meatVector = Order.createMeatVector(builder, meat);


        Order.startOrder(builder);
        Order.addVeggies(builder, veggiesVector);
        Order.addDrinks(builder, drinksVector);
        Order.addBottles(builder, bottlesVector);
        Order.addMilk(builder, milkVector);
        Order.addBread(builder, breadVector);
        Order.addMeat(builder, meatVector);

        // Finish building the Order object and get its offset
        int orderOffset = Order.endOrder(builder);
        // Finish the buffer and return the byte array
        builder.finish(orderOffset);

        return builder.sizedByteArray();
    }

    public static Health deserializeHealth(byte[] data) {
        // Create a ByteBuffer from the byte array
        ByteBuffer bb = ByteBuffer.wrap(data);
        // Get the root object from the buffer
        return Health.getRootAsHealth(bb);
    }


    public static void displayHealthData(byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        Health healthData  = Health.getRootAsHealth(bb);;
        System.out.println("Dispenser Status  " +healthData.dispenser() +  "\n");
        System.out.println("IceMaker Required  " +healthData.icemaker()+"\n");
        System.out.println("LightBulb Status  " +healthData.lightbulb()+"\n");
        System.out.println("Frrezer Temprature  " +healthData.freezerTemp()+"\n");
        System.out.println("Fridge Temprature  " +healthData.fridgeTemp()+"\n");
        System.out.println("Sensor Status  " +healthData.fridgeTemp());
    }

    public static void displayResponseData(byte[] data) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        Response responseData  = Response.getRootAsResponse(bb);
        System.out.println("Response Code  " +responseData.code());
       // System.out.println("Response Message  " +responseData.contents().toString());

    }

    public static void main(String[] args) {

      /* Order order_data = new Order();
       System.out.println(" ====== Serializing the Order Data  ===========");
       byte[] data =  OrderSerializer.serializeOrder(order_data);
       OrderSerializer.displayOrder(data);*/

        /*Health response_data = new Health();
        System.out.println(" ====== Serializing the Health Data  ===========");
        byte[] data=  OrderSerializer.serializeHealth(response_data);
        OrderSerializer.displayHealthData(data);*/

       Response response_data = new Response();
       System.out.println(" ====== Serializing the Response Data  ===========");
       byte[] data1 =  OrderSerializer.serializeResponse(response_data);
       OrderSerializer.displayResponseData(data1);


    }

}
