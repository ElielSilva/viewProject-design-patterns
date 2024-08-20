package br.edu.ifpe.viewProjectDesgnPatterns.Entities;

public enum ProjectTypes {
    FRONTEND {
        @Override
        public IDecorator getDecorator(IDecorator project) {
            return new FrontendDecorator(project);
        }
    }, BACKEND {
        @Override
        public IDecorator getDecorator(IDecorator project) {
            return new BackendDecorator(project);
        }
    }, DATABASE {
        @Override
        public IDecorator getDecorator(IDecorator project) {
            return new DatabaseDecorator(project);
        }
    }, MOBILE {
        @Override
        public IDecorator getDecorator(IDecorator project) {
            return new MobileDecorator(project);
        }
    };

    public abstract IDecorator getDecorator(IDecorator project);
}

