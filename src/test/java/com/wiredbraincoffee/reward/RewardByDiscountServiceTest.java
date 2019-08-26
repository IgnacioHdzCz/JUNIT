package com.wiredbraincoffee.reward;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import  org.junit.jupiter.api.Test;

import com.wiredbraincoffee.product.Product;



public class RewardByDiscountServiceTest {

	@Test
	void setNeededPoints() {
		RewardByDiscountService reward = new RewardByDiscountService();
		reward.setNeededPoint(100);
		assertEquals(100, reward.getNeededPoint());
	}

	
	@Test
	void setPercentageForPoints() {
		RewardByDiscountService reward = new RewardByDiscountService();
		reward.setPercentaje(0.1);
		assertEquals(0.1, reward.getPercentaje());
	}
	
	
	@Test
	void zeroCustomerPoints() {
		RewardByDiscountService reward = new RewardByDiscountService();
		reward.setPercentaje(0.1);
		reward.setPercentaje(100);
		
		Product smallDecaf = new Product(1, "Small Decaf", 0);
		List<Product> order = Collections.singletonList(smallDecaf);
		
		RewardInformation info = reward.applyReward(order, 0);
		assertEquals(0, info.getDiscount());
		assertEquals(0, info.getPointsRedeemed());
	}
}
