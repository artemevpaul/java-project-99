FROM gradle:8.9-jdk21

WORKDIR /app

COPY . .
RUN gradle --no-daemon installDist

ENV JWT_PRIVATE_KEY_PATH="file:/app/certs/private.pem" \
    JWT_PUBLIC_KEY_PATH="file:/app/certs/public.pem"

SHELL ["/bin/sh", "-lc"]

CMD 'mkdir -p /app/certs; \
     if [ -n "${JWT_PRIVATE_KEY:-}" ]; then printf "%b" "$JWT_PRIVATE_KEY" | sed "s/\r$//" > /app/certs/private.pem; fi; \
     if [ -n "${JWT_PUBLIC_KEY:-}" ];  then printf "%b" "$JWT_PUBLIC_KEY"  | sed "s/\r$//" > /app/certs/public.pem;  fi; \
     exec ./build/install/app/bin/app'
