package com.flowpowered.math;

import com.flowpowered.math.HashFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HashFunctionsTest {

  @Test
  public void fastCeilInputZeroOutputZero() {

    final float v = 0.0f;
    final int retval = HashFunctions.fastCeil(v);
    Assert.assertEquals(0, retval);

  }

  @Test
  public void fastCeilInputPositiveOutputPositive() {

    final float v = 1.5f;
    final int retval = HashFunctions.fastCeil(v);
    Assert.assertEquals(2, retval);

  }


  @Test
  public void fastCeilInputNegativeOutputZero() {

    final float v = -0.5f;
    final int retval = HashFunctions.fastCeil(v);
    Assert.assertEquals(0, retval);

  }

  @Test
  public void fastCeilInputNegativeOutputNegative() {

    final float v = -1.5f;
    final int retval = HashFunctions.fastCeil(v);
    Assert.assertEquals(-1, retval);

  }

  @Test
  public void hashInputNullOutputZero() {

    final Object object = null;
    final int retval = HashFunctions.hash(object);
    Assert.assertEquals(0, retval);

  }

  @Test
  public void hashIntInputZeroOutputZero() {

    final int value = 0;
    final int retval = HashFunctions.hash(value);
    Assert.assertEquals(0, retval);

  }

  @Test
  public void hashDoubleInputPositiveOutputPositive() {

    final double value = 2.0;
    final int retval = HashFunctions.hash(value);
    Assert.assertEquals(1073741824, retval);

  }

  @Test
  public void hashFloatInputNegativeOutputNegative() {

    final float value = -5.0f;
    final int retval = HashFunctions.hash(value);
    Assert.assertEquals(-817511080, retval);

  }

}
