package ${basePackage}.service.impl;

import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public void save(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Mapper.insert(${modelNameLowerCamel});
    }

    @Override
    public void deleteById(${keyType} id) {
        ${modelNameLowerCamel}Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Mapper.updateByPrimaryKey(${modelNameLowerCamel});
    }

    @Override
    public ${modelNameUpperCamel} findById(${keyType} id) {
        return ${modelNameLowerCamel}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<${modelNameUpperCamel}> findAll() {
        return ${modelNameLowerCamel}Mapper.selectAll();
    }


}
