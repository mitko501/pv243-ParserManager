/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pv243.service.batching.job;

import cz.fi.muni.pv243.entity.Parser;
import cz.fi.muni.pv243.infinispan.annotation.CachedStore;
import cz.fi.muni.pv243.infinispan.store.CachedParserStore;
import java.util.List;
import javax.batch.api.Batchlet;
import static javax.batch.runtime.BatchStatus.COMPLETED;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Michaela Bocanova
 */
@Named("parserBatchlet")
@ApplicationScoped
public class ParserBatchlet implements Batchlet {

    @Inject
    @CachedStore
    private CachedParserStore parserStore;
    
    @Override
    public String process() throws Exception {
        
        List<Parser> parsers = parserStore.getAllParsers();
        for (Parser parser : parsers) {
        
        }
        return COMPLETED.toString();
    }

    @Override
    public void stop() throws Exception {
        //log
    }
    
}
