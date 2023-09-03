import pytest

def test_add():
    num1 = 3
    num2= 5
    
    sum = num1 + num2
    
    assert sum == 8
    
def test_subtract():
    num1 = 50
    num2 = 20
    
    diff = num1 - num2
    assert diff == 30
    
@pytest.mark.activity        
def test_product():
    num1 = 5
    num2 = 4
    
    product = num1 * num2
    
    assert product == 20

@pytest.mark.activity
def test_division():
    num1 = 100
    num2 = 2
    
    quotient = num1 / num2
    
    assert quotient == 50
    