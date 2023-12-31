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
public final class Milk extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static Milk getRootAsMilk(ByteBuffer _bb) { return getRootAsMilk(_bb, new Milk()); }
  public static Milk getRootAsMilk(ByteBuffer _bb, Milk obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Milk __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public byte type() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public float quantity() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }

  public static int createMilk(FlatBufferBuilder builder,
      byte type,
      float quantity) {
    builder.startTable(2);
    Milk.addQuantity(builder, quantity);
    Milk.addType(builder, type);
    return Milk.endMilk(builder);
  }

  public static void startMilk(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addType(FlatBufferBuilder builder, byte type) { builder.addByte(0, type, 0); }
  public static void addQuantity(FlatBufferBuilder builder, float quantity) { builder.addFloat(1, quantity, 0.0f); }
  public static int endMilk(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Milk get(int j) { return get(new Milk(), j); }
    public Milk get(Milk obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

