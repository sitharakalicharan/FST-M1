import pytest

def test_sum(num_list):
    sum = 0
    for i in num_list:
        sum = sum + i
    assert sum == 55
        