package com.sncf.fusion.demo.feature.infra.adapters.secondary;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.sncf.fusion.demo.feature.domain.Feature;
import com.sncf.fusion.demo.feature.domain.Vote;
import com.sncf.fusion.demo.feature.domain.ports.secondary.FeatureRecords;
import com.sncf.fusion.demo.feature.infra.adapters.secondary.dto.FeatureMongoRecord;
import com.sncf.fusion.demo.patternity.annotation.designpattern.Adapter;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

@Repository
@com.sncf.fusion.demo.patternity.annotation.ddd.stereotype.Repository
@Adapter
public class FeatureRecordsMongoRepository implements FeatureRecords {

    private String  mongoHost = "127.0.0.1";

    private Integer  mongoPort = 27017;

    private MongoClient client;
    private MongoDatabase database;
    private String collectionName ="feature";

    public FeatureRecordsMongoRepository() {
        CodecRegistry pojoCodecRegistry = fromRegistries(com.mongodb.MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(String.format("mongodb://%s:%d", mongoHost, mongoPort)))
                .codecRegistry(pojoCodecRegistry)
                .build();
        this.client = MongoClients.create(mongoClientSettings);
        this.database = client.getDatabase("featurebrawl").withCodecRegistry(pojoCodecRegistry);
    }

    @Override
    public List<Feature> getAllFeatures() {
        return StreamSupport.stream(database.getCollection(collectionName, FeatureMongoRecord.class)
                .find().spliterator(), false).map(FeatureMongoRecord::toFeature)
                .collect(Collectors.toList());
    }

    @Override
    public Feature getOneFeature(String featureId) {
        FeatureMongoRecord featureMongoRecord = database.getCollection(collectionName, FeatureMongoRecord.class)
                .find(Filters.eq("id",featureId)).first();
        return (Objects.nonNull(featureMongoRecord)) ? featureMongoRecord.toFeature() : null;
    }

    @Override
    public String addFeature(Feature feature) {
        FeatureMongoRecord featureMongoRecord = new FeatureMongoRecord(feature);
        database.getCollection(collectionName, FeatureMongoRecord.class).insertOne(featureMongoRecord);
        return featureMongoRecord.getId();
    }

    @Override
    public Boolean vote(String featureId, Vote vote) {
        MongoCollection<FeatureMongoRecord> featureMongoRecord = database.getCollection(collectionName, FeatureMongoRecord.class);
        Bson listItem = new BasicDBObject("votes", new BasicDBObject("note", vote.getNote()).append("author", vote.getAuthor()));
        Bson updateQuery = new BasicDBObject("$push", listItem);
        Bson findQuery = new BasicDBObject("_id", featureId);
        UpdateResult result = featureMongoRecord.updateOne(findQuery, updateQuery);
        return result.getModifiedCount() > 0;
    }
}
