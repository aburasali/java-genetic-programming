package com.github.chen0040.gp.treegp.program.operators;


import com.github.chen0040.gp.exceptions.SizeMismatchedException;
import com.github.chen0040.gp.treegp.program.Operator;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.*;


/**
 * Created by xschen on 11/5/2017.
 */
public class IfGreaterThanUnitTest {

   @Test
   public void test_makeCopy(){
      IfGreaterThan op1 = new IfGreaterThan();
      Operator op2 = op1.makeCopy();
      assertThat(op1).isEqualTo(op2);
   }

   @Test
   public void test_ifGreaterThan(){
      IfGreaterThan op1 = new IfGreaterThan();
      op1.read(Arrays.asList(0.1, 0.05, 1.0, 2.0));
      op1.execute();
      assertThat(op1.getValue()).isEqualTo(1.0);
   }

   @Test
   public void test_ifNotGreaterThan(){
      IfGreaterThan op1 = new IfGreaterThan();
      op1.read(Arrays.asList(0.1, 0.5, 1.0, 2.0));
      op1.execute();
      assertThat(op1.getValue()).isEqualTo(2.0);
   }

   @Test(expectedExceptions = SizeMismatchedException.class)
   public void test_readException(){

      IfGreaterThan op1 = new IfGreaterThan();
      op1.read(Arrays.asList(0.1, 0.5, 1.0));
   }

}