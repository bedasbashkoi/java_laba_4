package CSV;

import DOMAIN_MODEL.Human;
import DOMAIN_MODEL.Subdivision;
import MAIN.Mapper;

public class Human_Mapper implements Mapper<Human, Human_Data> {
    final ID_Generator generator = new ID_Generator();

    @Override
    public Human toDomain(Human_Data dto) {
        var subdivision = new Subdivision(generator.generateNewId(), dto.getSubdiv());
        return new Human(dto.getId(), dto.getName(), dto.getSex(), dto.getDateOfBirth(), subdivision, dto.getSalary());
    }

    @Override
    public Human_Data fromDomain(Human domain) {
        return new Human_Data(domain.id(), domain.name(), domain.sex(), domain.dateOfBirth(), domain.subdiv().name(), domain.salary());
    }
}