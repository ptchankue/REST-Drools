package net.africanbank.utils;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.PackageBuilder;
import org.drools.io.ResourceFactory;

/**
 * Created by patricktchankue on 6/2/16.
 */
public class DroolsUtil {
    KnowledgeBase knowledgeBase;
    KnowledgeBuilder builder;

    PackageBuilder pkgBuilder = new PackageBuilder();


    public DroolsUtil(){
        this.knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        this.builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    }

    public KnowledgeBase createKnowledgeBase(String rule_file) {
        this.builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        builder.add(ResourceFactory.newClassPathResource(rule_file), ResourceType.DRL);

        if (builder.hasErrors()) {
            throw new RuntimeException(builder.getErrors().toString());
        }

        this.knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
        return this.knowledgeBase;
    }

    //public
}
