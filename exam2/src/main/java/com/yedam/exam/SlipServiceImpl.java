package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SlipServiceImpl implements SlipService{

	@Autowired	
	SlipDAO dao;
	
	@Override
	public List<String> insertSlip(List<Slip> slip) {
		//테이블 입력
		List<String> str = new ArrayList<String>();
		
		for(int i=0; i<slip.size(); i++) {
			Slip vo = slip.get(i);
			int sal = vo.getSlipAmount();
			String empId = vo.getCustomer().substring(0, 3);
			if(sal >= 20000) {
				vo.setSlipAmount(20000);
				str.add(empId);
			} 	
			dao.insertSlip(vo);				
		}
		
		return str;  // 처리 건수 리턴;
	}
	
}
