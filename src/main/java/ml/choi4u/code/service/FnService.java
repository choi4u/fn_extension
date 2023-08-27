package ml.choi4u.code.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ml.choi4u.code.model.FnVO;
import ml.choi4u.code.repository.FnMapper;

@Service("fnService")
public class FnService {
	@Autowired
	private FnMapper fnMapper;
	
	public ArrayList<FnVO> selectFnExtension(FnVO vo) throws Exception {
		return fnMapper.selectFnExtension(vo); 
	}
	public ArrayList<FnVO> selectFnExtensionChk(FnVO vo) throws Exception {
		return fnMapper.selectFnExtensionChk(vo); 
	}
	
	public int updateFnDef(FnVO vo) throws Exception {
		return fnMapper.updateFnDef(vo);
	}

	public int insertFnAdd(FnVO vo) throws Exception {
		if(fnMapper.selectFnExtension(vo).isEmpty()) {
			return fnMapper.insertFnAdd(vo);
		} else {
			return 0;
		}
	}
	
	public int deleteFnAdd(FnVO vo) throws Exception {
		return fnMapper.deleteFnAdd(vo);
	}
}
