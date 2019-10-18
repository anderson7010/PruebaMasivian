-- DATABASE
CREATE DATABASE "Masivian_DB"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "Masivian_DB"
    IS 'Masivian test database';
-- DATABASE

-- TREE SEQUENCE
CREATE SEQUENCE public.seq_tree_id;

ALTER SEQUENCE public.seq_tree_id
    OWNER TO postgres;

COMMENT ON SEQUENCE public.seq_tree_id
    IS 'Tree identifier';
-- TREE SEQUENCE

-- TREE TABLE
CREATE TABLE public.tree
(
    id integer NOT NULL DEFAULT nextval('seq_tree_id'::regclass),
    CONSTRAINT pk_tree_id PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tree
    OWNER to postgres;
COMMENT ON TABLE public.tree
    IS 'Binary trees';
-- TREE TABLE

-- NODE SEQUENCE
CREATE SEQUENCE public.seq_node_id;

ALTER SEQUENCE public.seq_node_id
    OWNER TO postgres;

COMMENT ON SEQUENCE public.seq_node_id
    IS 'Node identifier sequence';
-- NODE SEQUENCE

--NODE TABLE
CREATE TABLE public.node
(
    id integer NOT NULL DEFAULT nextval('seq_node_id'::regclass),
    tree_id integer NOT NULL,
    node_value integer NOT NULL,
    left_node_value integer,
    right_node_value integer,
    node_level integer NOT NULL,
    CONSTRAINT pk_node_id PRIMARY KEY (id),
    CONSTRAINT fk_node_tree_id FOREIGN KEY (tree_id)
        REFERENCES public.tree (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.node
    OWNER to postgres;
COMMENT ON TABLE public.node
    IS 'Nodes of the binary tree';
--NODE TABLE