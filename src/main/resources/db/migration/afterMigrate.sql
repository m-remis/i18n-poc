delete
from "i18n_messages";

insert into "i18n_messages"(id, customer_id, locale, module, key, message, creation_ts, update_ts)
values ('1', 'default', 'en-US', 'app-login', 'login', 'Sign in', now(), now()),
       ('2', 'default', 'en-US', 'app-login', 'welcome.by', 'by {{customer}}', now(), now()),
       ('3', 'default', 'en-US', 'app-login', 'welcome.startButton.label', 'Start', now(), now()),
       ('4', 'default', 'en-US', 'app-login', 'login.heading', 'Name of application', now(), now()),
       ('6', 'default', 'en-US', 'app-login', 'login.form.generalLabel', 'General', now(), now()),
       ('7', 'default', 'en-US', 'app-login', 'login.form.email', 'email', now(), now()),
       ('8', 'default', 'en-US', 'app-login', 'login.form.password', 'password', now(), now()),
-- Translations second language
       ('9', 'default', 'sk-SK', 'app-login', 'login', 'Prihlásiť sa', now(), now()),
       ('10', 'default', 'sk-SK', 'app-login', 'welcome.by', 'od {{customer}}', now(), now()),
       ('11', 'default', 'sk-SK', 'app-login', 'welcome.startButton.label', 'Štart', now(), now()),
       ('12', 'default', 'sk-SK', 'app-login', 'login.heading', 'Meno aplikácie', now(), now()),
       ('13', 'default', 'sk-SK', 'app-login', 'login.form.generalLabel', 'Hlavné', now(), now()),
       ('14', 'default', 'sk-SK', 'app-login', 'login.form.email', 'email', now(), now()),
       ('15', 'default', 'sk-SK', 'app-login', 'login.form.password', 'heslo', now(), now()),
-- Second module
       ('16', 'default', 'en-US', 'module-2', 'key1', 'value', now(), now()),
       ('17', 'default', 'en-US', 'module-2', 'key2', 'value', now(), now()),
-- Translations second language
       ('18', 'default', 'sk-SK', 'module-2', 'login', 'hodnota', now(), now()),
       ('19', 'default', 'sk-SK', 'module-2', 'welcome.by', 'hodnota', now(), now()) on conflict do nothing;

-- Customer-1 translations
insert into "i18n_messages"(id, customer_id, locale, module, key, message, creation_ts, update_ts)
values ('20', 'customer-1', 'en-US', 'app-login', 'login', 'Sign in - override', now(), now()),
       ('21', 'customer-1', 'en-US', 'app-login', 'welcome.by', 'by {{customer}} - override', now(), now()),
-- Translations second language
       ('22', 'customer-1', 'sk-SK', 'app-login', 'login', 'Prihlásiť sa - - override', now(), now()),
       ('23', 'customer-1', 'sk-SK', 'app-login', 'welcome.by', 'od {{customer}} - override', now(),
        now()) on conflict do nothing;