help:
	@echo '@TODO'

login:
	docker login registry.gitlab.com

# TODO: Missing a docker/local to build a single arch image to be used in a compose.yml also to be created
docker/registry: login
	docker build \
		--platform linux/amd64 \
		--file prod.Dockerfile . \
		--tag registry.gitlab.com/afonsodemori/spring-playground:latest \
		--push
