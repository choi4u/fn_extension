package ml.choi4u.code.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import ml.choi4u.code.model.FnVO;

@Mapper
public interface FnMapper {
	ArrayList<FnVO> selectFnExtension(FnVO vo);
	ArrayList<FnVO> selectFnExtensionChk(FnVO vo);
	int updateFnDef(FnVO vo);
	int insertFnAdd(FnVO vo);
	int deleteFnAdd(FnVO vo);
}
