
create table application_queue(
      id int not null primary key,
      rule_name varchar_ignorecase(50) not null,
      application_type varchar_ignorecase(50) not null,
      queue_name varchar_ignorecase(50) not null,
      reason_code varchar_ignorecase(50) not null,
      result varchar_ignorecase(200)
);

create table product_variant(
      id int not null primary key,
      rule_name varchar_ignorecase(50) not null,
      product varchar_ignorecase(150) not null,
      variant varchar_ignorecase(150) not null,
      result varchar_ignorecase(200)
);

create table credit_limit(
      id int not null primary key,
      card_type varchar_ignorecase(50) not null,
      num_credit_card varchar_ignorecase(50) not null,
      home_owner varchar_ignorecase(50) not null,
      result double
);

create table mort_rules (
    rule_cond varchar_ignorecase(200) not null ,
    rule_cons varchar_ignorecase(200) not null
);