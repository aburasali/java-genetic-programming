package com.github.chen0040.gp.lgp.program.operators;


import com.github.chen0040.gp.lgp.enums.OperatorExecutionStatus;
import com.github.chen0040.gp.lgp.program.Register;
import com.github.chen0040.gp.lgp.program.Operator;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.assertEquals;


/**
 * Created by xschen on 1/5/2017.
 */
public class SqrtUnitTest {

   @Test
   public void test_neg(){
      Operator op = new Sqrt();

      Register reg1 = new Register();
      Register reg2 = new Register();
      Register destination = new Register();

      reg1.setValue(-4);

      assertThat(op.execute(reg1, reg2, destination, null)).isEqualTo(OperatorExecutionStatus.LGP_EXECUTE_NEXT_INSTRUCTION);

      assertThat(destination.getValue()).isEqualTo(2);
   }

   @Test
   public void test_pos(){
      Operator op = new Sqrt();

      Register reg1 = new Register();
      Register reg2 = new Register();
      Register destination = new Register();

      reg1.setValue(4);

      assertThat(op.execute(reg1, reg2, destination, null)).isEqualTo(OperatorExecutionStatus.LGP_EXECUTE_NEXT_INSTRUCTION);

      assertThat(destination.getValue()).isEqualTo(2);
   }

   @Test
   public void test_makeCopy(){
      Operator op = new Sqrt();
      assertEquals(op, op.makeCopy());
   }
}
