package de.wwu.pi.acse.adder.businesslogic;

import de.wwu.pi.acse.adder.model.MyNumber;
import org.springframework.stereotype.Service;

@Service
public class AdderServiceImpl implements AdderService {
  @Override
  public MyNumber add(MyNumber obj1, MyNumber obj2) {
    int sum = obj1.getNumber() + obj2.getNumber();

    MyNumber result = new MyNumber();
    result.setNumber(sum);

    return result;
  }
}
