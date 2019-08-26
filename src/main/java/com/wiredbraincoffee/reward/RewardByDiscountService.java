package com.wiredbraincoffee.reward;

import java.util.List;

import com.wiredbraincoffee.product.Product;

public class RewardByDiscountService extends RewardByConversionService {
	private double percentaje;
	private double neededPoint;
	
	@Override
	public RewardInformation applyReward(
		   List<Product> order, long customerPoints) {
	   RewardInformation rewardInformation = new RewardInformation();
	   
	   if (customerPoints >= neededPoints) {
		   double orderTotal = calculateTotal(order);
		   double discount = orderTotal * percentaje;
		   rewardInformation = new RewardInformation(
				   neededPoints, discount);
		
	}
	   
	return rewardInformation;
   }

public double getPercentaje() {
	return percentaje;
}

public void setPercentaje(double percentaje) {
	if (percentaje > 0) {
		this.percentaje = percentaje;
	} else {
		throw new IllegalArgumentException(
				"Percentaje should be greater than zero");
	}
	
}

public double getNeededPoint() {
	return neededPoint;
}

public void setNeededPoint(double neededPoint) {
	this.neededPoint = neededPoint;
}
   

   

}
