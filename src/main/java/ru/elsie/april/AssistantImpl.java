package ru.elsie.april;

import ru.elsie.april.infrastructure.InjectByType;

import javax.annotation.PostConstruct;

public class AssistantImpl implements Assistant {

    @InjectByType
    private Advertiser advertiser;

    @PostConstruct
    public void init() {
        System.out.println("** AssistantImpl uses class " + advertiser.getClass() + " **");
    }

    @Override
    public void assist() {
        System.out.println("What are you interested in?");
    }
}
