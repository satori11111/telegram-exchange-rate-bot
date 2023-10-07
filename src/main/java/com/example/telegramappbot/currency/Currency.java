package com.example.telegramappbot.currency;

import lombok.Data;

@Data
public class Currency {
   private String txt;
   private Double rate;
   private String cc;

   @Override
   public String toString() {
      return "Валюта = " + txt +
              "(" + cc + ")"  +
              ", курс = " + rate;
   }
}
