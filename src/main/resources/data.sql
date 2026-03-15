--
-- Este script SQL é executado sempre que a aplicação inicia.
--

--
-- Incluir alguns registros na tabela [segmentos].
INSERT INTO segmentos
    ( id, st_nome, dt_criacao )
VALUES
    (1, 'Tecnologia', NOW() ),
    (2, 'Comércio', NOW() ),
    (3, 'Indústria', NOW() ),
    (4, 'Serviços', NOW() ),
    (5, 'Agronegócio', NOW() );

--
-- Incluir alguns registros na tabela [empreendimentos].
INSERT INTO empreendimentos
    ( st_nome, st_responsavel, st_municipio, id_segmento, st_email, fl_ativo, dt_criacao )
VALUES
    ('Infotech Soluções', 'Cláudia Bianca Teixeira', 'Florianópolis', 1, 'infotech.floripa@gmail.com', 1, NOW() ),
    ('Igor Alimentos ME', 'Igor Rodrigo Osvaldo Rodrigues', 'Florianópolis', 2, 'igor.me@gmail.com', 1, NOW() ),
    ('Samuel Cabelos ME', 'Samuel Victor Almada', 'Palhoça', 4, 'samuel.cabelos@gmail.com', 1, NOW() ),
    ('Postdata', 'Elias Kauê Pietro Bernardes', 'Florianópolis', 1, 'postdata@gmail.com', 1, NOW() ),
    ('Ana Julia ME', 'Ana Julia Moura', 'São José', 4, '123@gmail.com', 1, NOW() ),
    ('Morangos Raquel ME', 'Raquel Amanda Silvana Dias', 'Alfredo Wagner', 5, 'morangos.raquel@gmail.com', 1, NOW() ),
    ('Future Now ME', 'Alexandre Felipe Samuel Barbosa', 'Florianópolis', 1, '123@gmail.com', 1, NOW() ),
    ('FDM Web Solutions', 'Filipe Diego Moraes', 'Joinville', 1, 'future.now.me@gmail.com', 1, NOW() ),
    ('Semijoias Kami', 'Kamilly Lavínia Bianca Martins', 'Biguaçu', 2, 'semijoias.kami@gmail.com', 1, NOW() ),
    ( 'Multiplacas ME', 'Luís Diogo Daniel Pires', 'São josé', 3, 'multiplacas@gmail.com', 1, NOW() ),
    ( 'Hortaliças Caio ME', 'Caio Matheus da Luz', 'Alfredo Wagner', 5, 'hortalicas.caio@gmail.com', 1, NOW() ),
    ( 'FL Beleza ME', 'Fátima Luana Nascimento', 'Balneário Camboriú', 4, 'flbeleza@gmail.com', 1, NOW() ),
    ( 'DG Tech', 'Danilo Iago Gomes', 'São José', 1, 'dgtech@gmail.com', 1, NOW() ),
    ( 'Arroz Pronto', 'Sophia Betina Almeida', 'Tijucas', 5, 'arrozpronto@gmail.com', 1, NOW() ),
    ( 'Rebites CDP', 'Clarice Daniela de Paula', 'Palhoça', 3, 'rebites.cdp@gmail.com', 1, NOW() ),
    ( 'Rezende Sistemas', 'Nelson Murilo Almada', 'Florianópolis', 1, 'rezende.sistemas@gmail.com', 1, NOW() ),
    ( 'Vendemais', 'Jennifer Mirella Rezende', 'Florianópolis', 2, 'vendemais@gmail.com', 1, NOW() ),
    ( 'Flores Heloise', 'Heloise Sabrina Araújo', 'Gaspar', 5, 'flores.heloise@gmail.com', 1, NOW() );
