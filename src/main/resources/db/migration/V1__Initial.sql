create table "i18n_messages"
(
    "id"          varchar(36) primary key,
    "customer_id" varchar(36),
    "locale"      varchar(100) not null,
    "module"      varchar(100) not null,
    "key"         varchar(255) not null,
    "message"     varchar(255) not null,
    "creation_ts" timestamp without time zone not null,
    "update_ts"   timestamp without time zone not null,
    constraint unique_customer_module_key_locale unique ("customer_id", "module", "key", "locale")
);