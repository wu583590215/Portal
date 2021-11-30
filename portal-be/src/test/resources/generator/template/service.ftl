package ${basePackage}.service;
import ${basePackage}.entity.${modelNameUpperCamel};
import java.util.List;



/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service {
    void save(${modelNameUpperCamel} model);
    void deleteById(${keyType} id);
    void update(${modelNameUpperCamel} model);
    ${modelNameUpperCamel} findById(${keyType} id);
    List<${modelNameUpperCamel}> findAll();
 }
