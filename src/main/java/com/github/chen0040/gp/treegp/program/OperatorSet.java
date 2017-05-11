package com.github.chen0040.gp.treegp.program;


import com.github.chen0040.gp.commons.EntityContainer;
import com.github.chen0040.gp.treegp.program.operators.IfGreaterThan;
import com.github.chen0040.gp.treegp.program.operators.IfLessThan;

import java.io.Serializable;


/**
 * Created by xschen on 29/4/2017.
 */
public class OperatorSet extends EntityContainer<Operator> implements Serializable {

   public OperatorSet(){

   }

   public boolean isReadOnly(){
      return false;
   }

   public OperatorSet makeCopy(){
      OperatorSet clone = new OperatorSet();
      clone.copy(this);
      return clone;
   }

   public void addIfLessThanOperator() {
      addIfLessThanOperator(1.0);
   }

   public void addIfLessThanOperator(double weight)
   {
      add(new IfLessThan(), weight);
   }

   public void addIfGreaterThanOperator() {
      addIfGreaterThanOperator(1.0);
   }

   public void addIfGreaterThanOperator(double weight)
   {
      add(new IfGreaterThan(), weight);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < entities.size(); ++i){
         if(i != 0){
            sb.append("\r\n");
         }
         sb.append("operator[").append(i).append("]: ").append(entities.get(i));
      }
      return sb.toString();
   }
}