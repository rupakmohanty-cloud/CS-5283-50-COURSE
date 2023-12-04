// automatically generated by the FlatBuffers compiler, do not modify

package com.networking.flatbuffers.zmq;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Drink extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static Drink getRootAsDrink(ByteBuffer _bb) { return getRootAsDrink(_bb, new Drink()); }
  public static Drink getRootAsDrink(ByteBuffer _bb, Drink obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Drink __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int coke() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int beer() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int juice() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createDrink(FlatBufferBuilder builder,
      int coke,
      int beer,
      int juice) {
    builder.startTable(3);
    Drink.addJuice(builder, juice);
    Drink.addBeer(builder, beer);
    Drink.addCoke(builder, coke);
    return Drink.endDrink(builder);
  }

  public static void startDrink(FlatBufferBuilder builder) { builder.startTable(3); }
  public static void addCoke(FlatBufferBuilder builder, int coke) { builder.addInt(0, coke, 0); }
  public static void addBeer(FlatBufferBuilder builder, int beer) { builder.addInt(1, beer, 0); }
  public static void addJuice(FlatBufferBuilder builder, int juice) { builder.addInt(2, juice, 0); }
  public static int endDrink(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Drink get(int j) { return get(new Drink(), j); }
    public Drink get(Drink obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

