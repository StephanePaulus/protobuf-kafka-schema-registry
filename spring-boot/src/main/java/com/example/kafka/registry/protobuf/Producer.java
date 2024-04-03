package com.example.kafka.registry.protobuf;

import com.proto.customer.onboarding.v1.Address;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

  private final KafkaTemplate<String, Address> kafkaTemplate;

  @PostConstruct
  public void postConstruct() {
    kafkaTemplate.send("stg.cu.onboarding.address", "test1", Address.getDefaultInstance());
  }
}
