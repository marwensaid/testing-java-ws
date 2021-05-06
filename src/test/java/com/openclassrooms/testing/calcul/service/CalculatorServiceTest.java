package com.openclassrooms.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassrooms.testing.calcul.domain.Calculator;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;
import com.openclassrooms.testing.calcul.domain.model.CalculationType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	@Mock
	Calculator calculator;
	// Calculator IS CALLED BY CalculatorService
	CalculatorService classUnderTest;

	@BeforeEach
	public void init(){
		classUnderTest = new CalculatorServiceImpl(calculator);
	}

	@Test
	public void add_returnsTheSum_ofTwoPositiveNumbers() {
		final int result = classUnderTest.calculate(
				new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void add_returnsTheSum_ofTwoNegativeNumbers() {
		final int result = classUnderTest.calculate(
				new CalculationModel(CalculationType.ADDITION, -1, 2))
				.getSolution();

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void add_returnsTheSum_ofZeroAndZero() {
		final int result = classUnderTest.calculate(
				new CalculationModel(CalculationType.ADDITION, 0, 0)).getSolution();
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void calculateThisAddition(){
		// GIVEN
		when(calculator.add(1,2)).thenReturn(3);

		// WHEN
		Integer solution = classUnderTest.calculate(new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

		// THEN
		verify(calculator).add(1, 2);
		assertThat(solution).isEqualTo(3);
	}

	@Test
	public void calculateAnyAddition(){
		// GIVEN
		Random random = new Random();
		when(calculator.add(any(Integer.class),any(Integer.class))).thenReturn(3);

		// WHEN
		Integer solution = classUnderTest.calculate(new CalculationModel(CalculationType.ADDITION, random.nextInt(), random.nextInt())).getSolution();

		// THEN
		verify(calculator).add(any(Integer.class), any(Integer.class));
		assertThat(solution).isEqualTo(3);
	}


}
