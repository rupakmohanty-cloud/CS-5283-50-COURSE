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
public final class Bottle extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static Bottle getRootAsBottle(ByteBuffer _bb) { return getRootAsBottle(_bb, new Bottle()); }
  public static Bottle getRootAsBottle(ByteBuffer _bb, Bottle obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Bottle __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int sprite() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int pepsi() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int whitewine() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createBottle(FlatBufferBuilder builder,
      int sprite,
      int pepsi,
      int whitewine) {
    builder.startTable(3);
    Bottle.addWhitewine(builder, whitewine);
    Bottle.addPepsi(builder, pepsi);
    Bottle.addSprite(builder, sprite);
    return Bottle.endBottle(builder);
  }

  public static void startBottle(FlatBufferBuilder builder) { builder.startTable(3); }
  public static void addSprite(FlatBufferBuilder builder, int sprite) { builder.addInt(0, sprite, 0); }
  public static void addPepsi(FlatBufferBuilder builder, int pepsi) { builder.addInt(1, pepsi, 0); }
  public static void addWhitewine(FlatBufferBuilder builder, int whitewine) { builder.addInt(2, whitewine, 0); }
  public static int endBottle(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Bottle get(int j) { return get(new Bottle(), j); }
    public Bottle get(Bottle obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

