create sequence "public"."hibernate_sequence";
create table "public"."account" (
    "id" bigint not null,
    "name" character varying(255)
);
CREATE UNIQUE INDEX account_pkey ON public.account USING btree (id);
alter table "public"."account" add constraint "account_pkey" PRIMARY KEY using index "account_pkey";
