--
-- Este script SQL é executado sempre que a aplicação inicia.
--

--
-- Incluir alguns registros na tabela [empreendimentos].
INSERT INTO empreendimentos
    ( st_nome, st_responsavel, st_municipio, tp_segmento, st_email, fl_ativo, dt_criacao )
VALUES
    ('Infotech Soluções', 'Cláudia Bianca Teixeira', 'Florianópolis', 'TECNOLOGIA', 'infotech.floripa@gmail.com', 1, NOW() ),
    ('Igor Alimentos ME', 'Igor Rodrigo Osvaldo Rodrigues', 'Florianópolis', 'COMERCIO', 'igor.me@gmail.com', 1, NOW() ),
    ('Samuel Cabelos ME', 'Samuel Victor Almada', 'Palhoça', 'SERVICOS', 'samuel.cabelos@gmail.com', 1, NOW() ),
    ('Postdata', 'Elias Kauê Pietro Bernardes', 'Florianópolis', 'TECNOLOGIA', 'postdata@gmail.com', 1, NOW() ),
    ('Ana Julia ME', 'Ana Julia Moura', 'São José', 'SERVICOS', '123@gmail.com', 1, NOW() ),
    ('Morangos Raquel ME', 'Raquel Amanda Silvana Dias', 'Alfredo Wagner', 'AGRONEGOCIO', 'morangos.raquel@gmail.com', 1, NOW() ),
    ('Future Now ME', 'Alexandre Felipe Samuel Barbosa', 'Florianópolis', 'TECNOLOGIA', '123@gmail.com', 1, NOW() ),
    ('FDM Web Solutions', 'Filipe Diego Moraes', 'Joinville', 'TECNOLOGIA', 'future.now.me@gmail.com', 1, NOW() ),
    ('Semijoias Kami', 'Kamilly Lavínia Bianca Martins', 'Biguaçu', 'COMERCIO', 'semijoias.kami@gmail.com', 1, NOW() ),
    ( 'Multiplacas ME', 'Luís Diogo Daniel Pires', 'São josé', 'INDUSTRIA', 'multiplacas@gmail.com', 1, NOW() ),
    ( 'Hortaliças Caio ME', 'Caio Matheus da Luz', 'Alfredo Wagner', 'AGRONEGOCIO', 'hortalicas.caio@gmail.com', 1, NOW() ),
    ( 'FL Beleza ME', 'Fátima Luana Nascimento', 'Balneário Camboriú', 'SERVICOS', 'flbeleza@gmail.com', 1, NOW() ),
    ( 'DG Tech', 'Danilo Iago Gomes', 'São José', 'TECNOLOGIA', 'dgtech@gmail.com', 1, NOW() ),
    ( 'Arroz Pronto', 'Sophia Betina Almeida', 'Tijucas', 'AGRONEGOCIO', 'arrozpronto@gmail.com', 1, NOW() ),
    ( 'Rebites CDP', 'Clarice Daniela de Paula', 'Palhoça', 'INDUSTRIA', 'rebites.cdp@gmail.com', 1, NOW() ),
    ( 'Rezende Sistemas', 'Nelson Murilo Almada', 'Florianópolis', 'TECNOLOGIA', 'rezende.sistemas@gmail.com', 1, NOW() ),
    ( 'Vendemais', 'Jennifer Mirella Rezende', 'Florianópolis', 'COMERCIO', 'vendemais@gmail.com', 1, NOW() ),
    ( 'Flores Heloise', 'Heloise Sabrina Araújo', 'Gaspar', 'AGRONEGOCIO', 'flores.heloise@gmail.com', 1, NOW() );
